//
//  SDKInitializeCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "SDKInitializeCommand.h"

@implementation SDKInitializeCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *comment1 = @"\t// App ID: 在 App Analytics 创建应用后，进入数据报表页中，在“系统设置”-“编辑应用”页面里查看App ID。\n";
    NSString *comment2 = @"\t// 渠道 ID: 是渠道标识符，可通过不同渠道单独追踪数据。\n";
    NSString *code = @"\t[TalkingData sessionStarted:<#您的 App ID#> withChannelId:<#渠道 ID#>];";
    
    
    [self insertEditableWithInvocation:invocation contents:code editPosition:code.length+1];
    [self insertEditableWithInvocation:invocation contents:comment2 editPosition:comment2.length+1];
    [self insertEditableWithInvocation:invocation contents:comment1 editPosition:comment1.length+1];
    
    completionHandler(nil);
}

@end
